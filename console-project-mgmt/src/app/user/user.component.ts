import { Component, OnInit, ViewChild } from "@angular/core";
import { NgForm } from "@angular/forms";
import { User } from "./user.model";
import { UserService } from "./user.service";
import { Router, ActivatedRoute, ParamMap } from "@angular/router";

@Component({
  selector: "app-user",
  templateUrl: "./user.component.html",
  styleUrls: ["./user.component.css"]
})
export class UserComponent implements OnInit {
  @ViewChild("addForm") addNewUserForm: NgForm;
  newUser: User;
  userToEdit: User;
  //suserId:"";
  userAdded = false;
  private mode = "add";
  private users;
  private showUserDetails = false;

  constructor(
    private userService: UserService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.mode = "add";
    this.users = [];
    this.showUserDetails = false;
  }

  onSaveUser() {
    if (this.addNewUserForm.invalid) {
      return;
    }

    if (this.mode === "add") {
      this.newUser = new User(
        this.addNewUserForm.value.empId,
        this.addNewUserForm.value.firstName,
        this.addNewUserForm.value.lastName,
        null
      );

      // this.userService.addTask(this.newUser);
      this.users.push(this.newUser);
      if (this.users.length > 0) {
        this.showUserDetails = true;
      } else {
        this.showUserDetails = false;
      }
      this.onReset();
    } else {
      this.userToEdit.empId = this.addNewUserForm.value.empId;
      this.userToEdit.firstName = this.addNewUserForm.value.firstName;
      this.userToEdit.lastName = this.addNewUserForm.value.lastName;

      //this.userService.updateTask(this.userToEdit);
    }
    //this.userService.reset();
    // this.userAdded = true;
    //this.router.navigate(['/view_task']);
  }
  sortByType(val){
    this.users.sort(function(a, b){
      var x =  a.firstName.toLowerCase();
      var y =  b.firstName.toLowerCase();
          
      if (x < y) {return -1;}
      if (x > y) {return 1;}
      return 0;          
    });
  }

  onReset() {
    this.addNewUserForm.reset();
  }
}
