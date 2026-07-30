import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PanelModule } from 'primeng/panel';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { EmployeeServiceService } from '../employee-service.service';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';

interface LoginInterface {
    username: string;
    password: string;
}

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,PanelModule,InputTextModule,PasswordModule,ButtonModule,NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})


export class LoginComponent {
  username: string = '';
  password: string = '';
  loginSucces: boolean = false;
  private dataUrl = 'assets/products.json';
  baseUrl ="";//"http://localhost:8095/";
  constructor(private employeeService:EmployeeServiceService,private route:Router) {}
 
  onSubmit = function(this: LoginComponent){
    if((this.username=="" || this.username==undefined) && !(this.password=="" || this.password==undefined)){
       this.loginSucces = true;
    }else{
       let request=
        {
          "username": this.username,
          "password": this.password
        }

        this.employeeService.post(this.baseUrl+'auth/login', request)
        .subscribe({
          next: (response: any) => {
            sessionStorage.setItem("jwtToken", response?.token);
            sessionStorage.setItem("username", this.username);
            this.route.navigate(['dashboard']);
          },
          error: (error: any) => {
            if(error.status==403){
              this.loginSucces = true;
            }
            console.error(error);
          }
        });
    }
   
  
  }

  reset(this: LoginComponent){
      this.username="";
      this.password="";
  }
  
}
