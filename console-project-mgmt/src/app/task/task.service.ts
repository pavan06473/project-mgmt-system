import { Task } from './task.model';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';


const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
const BACKEND_URL = environment.apiURL;

@Injectable({ providedIn: 'root' })
export class TaskService {
  private tasks: Task[] = [];
  private tasksUpdated = new Subject<Task[]>();

  constructor(private http: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-type-min': 'application/json'
    })
  };
  

  getTasks() {
    this.http.get<{ status: string, data: any }>(BACKEND_URL + 'tasks')
      .subscribe(response => {
        this.tasks = response.data;
        this.tasksUpdated.next([...this.tasks]);
      });
  }

  getTask(taskId: number) {
    console.log("taskID number is " + taskId);
    return this.http.get<{ status: string, data: any }>(BACKEND_URL + 'tasks/' + taskId);
  }

  createTask(task: Task): Observable<{ message: string, data: any }> {
    task = {
      "endDate": "2019-09-29T11:27:16.284Z",
      "parentId": "empty parent",
      "priority": 0,
      "projectId": "99",
      "startDate": "2019-09-29T11:27:16.284Z",
      "status": "Completed",
      "task": "New work",
      "taskId": 111
    };
    console.log("task data after modification : " + JSON.stringify(task));
    let httpHeaders = new HttpHeaders({
      'Content-Type' : 'application/json',
      'Cache-Control': 'no-cache'
    }); 
    let options = {
      headers: httpHeaders
    }; 
    return this.http.post<{ message: string, data: any }>(BACKEND_URL + 'tasks', task, {
      observe: 'body',
      responseType: 'json'
    });
  }

  addTask(task: Task) {
    this.createTask(task)
      .subscribe((response) => {
        this.tasks.push(response.data);
        this.tasksUpdated.next([...this.tasks]);
      });
  }

  updateTask(task: Task) {
    this.http.put(BACKEND_URL + 'tasks/' + task.taskId, task)
      .subscribe(response => {
        const updatedTasks = [...this.tasks];
        const oldTaskIndex = updatedTasks.findIndex(t => t.taskId === task.taskId);
        updatedTasks[oldTaskIndex] = task;
        this.tasks = updatedTasks;
        this.tasksUpdated.next([...this.tasks]);
      });
  }

  deleteTask(taskId: number) {
    this.http.delete(BACKEND_URL + 'tasks/' + taskId)
      .subscribe(() => {
        const updatedTasks = this.tasks.filter(task => task.taskId !== taskId);
        this.tasks = updatedTasks;
        this.tasksUpdated.next([...this.tasks]);
      });
  }

  getTaskUpdateListener() {
    return this.tasksUpdated.asObservable();
  }

}
