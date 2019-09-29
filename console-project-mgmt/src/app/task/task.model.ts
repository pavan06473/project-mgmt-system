export class Task {
  public parentId: string;
  public task: string;
  public startDate: string;
  public endDate: string;
  public priority: number;
  public taskId: number;

  public projectId: string;
  public status: string;
  

  constructor(id: number, parentId: string, task: string, startDate: string, endDate: string, priority: number, taskId: number, projectId: string, status: string) {
    this.task = task;
    this.startDate = startDate;
    this.endDate = endDate;
    this.priority = priority;
    this.taskId = taskId;
    this.projectId = projectId;
    this.status = status;
  }
}
