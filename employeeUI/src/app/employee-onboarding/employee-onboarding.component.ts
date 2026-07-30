import { Component,OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EmployeeServiceService } from '../employee-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-employee-onboarding',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './employee-onboarding.component.html',
  styleUrl: './employee-onboarding.component.css'
})
export class EmployeeOnboardingComponent implements  OnInit {
currentIsoString!: string;
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
  constructor(private employeeService:EmployeeServiceService,private route:Router) {}

    ngOnInit() {
      this.currentIsoString = new Date().toISOString(); 
      this.employee.EmployeeID = "EMP"+this.currentIsoString.replaceAll("-","").replaceAll("T","").replaceAll(":","").replaceAll(".","").substring(0,17);
    }

    saveEmployee = function(this: EmployeeOnboardingComponent){
 
      const request = {
        employeeName: this.employee.ename,
        email: this.employee.Email,
        mobileNumber: this.employee.MobileNumber,
        gender: this.employee.Gender,
        dateOfBirth: this.employee.DateBirth,
        employeeId: this.employee.EmployeeID,
        designation: this.employee.Designation,
        department: this.employee.Department,
        manager: this.employee.Manager,
        employmentType: this.employee.EmploymentType,
        location: this.employee.Location,
        joiningDate: this.employee.JoiningDate,
        salary: this.employee.Salary,
        aadharNumber: this.employee.Aadhar,
        resumePath: this.employee.Resume,
        panNumber: this.employee.PAN,
        address: this.employee.Address,
        hrRemarks: this.employee.HRRemarks
    };

    this.employeeService.post('emp/employeeonboarding', request).subscribe({
          next: (response: any) => {
            console.log(response);
            this.route.navigate(['dashboard/menu']);
          },
          error: (error: any) => {
            if(error.status==403){
            
            }
            console.error(error);
          }
      });
  }

}
