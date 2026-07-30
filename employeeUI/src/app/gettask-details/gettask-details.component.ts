import { Component, OnInit } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmployeeServiceService } from '../employee-service.service';
import { ActivatedRoute,Router,RouterLink  } from '@angular/router';


@Component({
  selector: 'app-gettask-details',
  standalone: true,
  imports: [FormsModule,CommonModule,RouterLink],
  templateUrl: './gettask-details.component.html',
  styleUrl: './gettask-details.component.css'
})
export class GettaskDetailsComponent implements OnInit {
  taskId:any="NA";
  isDisabled:boolean=false;
  historyDetails:any=[];
  employee = {
    ename:"",
    Email:"",
    MobileNumber:"",
    Gender:"",
    DateBirth: "",
    EmployeeID:"",
    Designation:"",
    Department:"",
    Manager:"",
    EmploymentType:"",
    Location:"",
    JoiningDate: "",
    Salary: "",
    Aadhar:"",
    Resume:"",
    PAN:"",
    Address:"",
    HRRemarks:"",
  }
  constructor(private employeeService:EmployeeServiceService,private route: ActivatedRoute,private navigateRoute : Router) {}
  ngOnInit(): void {
    const params = new HttpParams(); 
     this.taskId = this.route.snapshot.paramMap.get('taskId');

     this.employeeService.get('tasks/getTaskByTaskId/'+this.taskId, params).subscribe({
          next: (response: any) => {
            this.employee = {
                ename: response.employeeName,
                Email: response.email,
                MobileNumber: response.mobileNumber,
                Gender:response.gender,
                DateBirth: response.dateOfBirth,
                EmployeeID: response.employeeId,
                Designation: response.designation,
                Department: response.department,
                Manager: response.manager,
                EmploymentType: response.employmentType,
                Location: response.location,
                JoiningDate: response.joiningDate,
                Salary: response.salary,
                Aadhar: response.aadharNumber,
                Resume: response.resumePath,
                PAN: response.panNumber,
                Address: response.address,
                HRRemarks: response.hrRemarks
            };
            this.getHistory();
            this.isDisabled = true;
            console.log(response)
          },
          error: (error: any) => {
            if(error.status==403){
            
            }
            console.error(error);
          }
      });
  }

  ngOnit(): void {
    
  }

  getHistory(){
   
   
    const params = new HttpParams(); 
  
    this.employeeService.get('history/getHistoryDetailsByEmployeeId/'+this.employee.EmployeeID, params).subscribe({
        next: (response: any) => {
        //  console.log(response);
          if(Array.isArray(response)){
            this.historyDetails = response;
          }else if(response?.length==0){

          }else{
            this.historyDetails[0] = response;
          }

        },
        error: (error: any) => {
          if(error.status==403){
            
          }
          console.error(error);
        }
      });
  }
   
  viewHistory(this:GettaskDetailsComponent){
    this.getHistory()
  }

  completeTask(this:GettaskDetailsComponent,type:String){
    let request={
      remarks:this.employee.HRRemarks,
      taskId:this.taskId,
      decision:"",
      status:""
    }
    if(type=="Approve"){
      request.decision="Approve";
      request.status="Approve";
    }else{
      request.decision="Reject";
       request.status="Reject";
    }
   
    const params = new HttpParams(); 
    const taskId = this.route.snapshot.paramMap.get('taskId');
    this.employeeService.post('tasks/completeTask/'+taskId, request).subscribe({
        next: (response: any) => {
          console.log(response);
         
          this.navigateRoute.navigate(['dashboard/menu']);
        },
        error: (error: any) => {
          if(error.status==403){
            
          }
          console.error(error);
        }
      });
  }
   
}
