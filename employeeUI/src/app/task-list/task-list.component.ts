import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';
import { HttpClient,HttpParams } from '@angular/common/http';
import { NgIf,NgFor,DatePipe  } from '@angular/common';
import { Router } from '@angular/router';
import { RouterLink,ActivatedRoute } from '@angular/router'; 
import { LeftmenuComponent } from '../leftmenu/leftmenu.component';
@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [NgIf,NgFor,DatePipe,RouterLink,LeftmenuComponent],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent implements OnInit{
  tasks:any=[];
  groupId:any="";
   baseUrl ="";
   constructor(private employeeService:EmployeeServiceService,private route:Router,private routeParams:ActivatedRoute) {}

    ngOnInit(): void {
    this.routeParams.paramMap.subscribe(params => {
          this.groupId = params.get('groupId');
     });
      console.log("test");
      this.loadTask();
    }

    loadTask(){
        const params = new HttpParams(); 
        this.employeeService.get(this.baseUrl+'tasks/group/'+this.groupId,params).subscribe({
             next: (response: any) => {
              this.tasks = response;
              console.log(response);
              this.route.navigate([]);
             },
             error: (error: any) => {
              
              
            }
        });
    }

    claim(this:TaskListComponent,task:any, type:string){
      if(type=='claim'){
        const params = new HttpParams();
        let username = sessionStorage.getItem("username");
        this.employeeService.post(this.baseUrl+'tasks/claim/'+task.taskId+"/"+username,params).subscribe({
              next: (response: any) => {
                this.tasks = response;
              this.route.navigate(['dashboard']);
              },
              error: (error: any) => {
                
                
              }
          });
      }else{
         const params = new HttpParams();
        let username = sessionStorage.getItem("username");
        this.employeeService.post(this.baseUrl+'tasks/unclaim/'+task.taskId+"/"+username,params).subscribe({
              next: (response: any) => {
                this.tasks = response;
              this.route.navigate(['dashboard']);
              },
              error: (error: any) => {
                
                
              }
          });
      }
    }
    complete(this:TaskListComponent,task:any){
      const params = new HttpParams();
      let username = sessionStorage.getItem("username");
       this.employeeService.post(this.baseUrl+'tasks/complete/'+task.taskId+"/"+username,params).subscribe({
             next: (response: any) => {
              this.tasks = response;
              console.log(response);
             },
             error: (error: any) => {
              
              
            }
        });
    }

}
