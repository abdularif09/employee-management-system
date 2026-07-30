import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';
import { HttpClient,HttpParams } from '@angular/common/http';
import { NgIf,NgFor,DatePipe  } from '@angular/common';
import { Router ,RouterOutlet,RouterLink} from '@angular/router';

@Component({
  selector: 'app-leftmenu',
  standalone: true,
  imports: [NgIf,NgFor,DatePipe,RouterLink,RouterOutlet],
  templateUrl: './leftmenu.component.html',
  styleUrl: './leftmenu.component.css'
})
export class LeftmenuComponent {
   group:any=[];

   baseUrl ="";
   constructor(private employeeService:EmployeeServiceService,private route:Router) {}

    ngOnInit(): void {
      console.log("test");
         const params = new HttpParams(); 
        this.employeeService.get(this.baseUrl+'tasks/group/all',params).subscribe({
             next: (response: any) => {
              this.group = response;
              console.log(response);
              this.route.navigate([]);
             },
             error: (error: any) => {
              
              
            }
        });
    }

    loadTasks(this:LeftmenuComponent){
      this.group = this.group;
    }
}
