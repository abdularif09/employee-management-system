import { Routes } from '@angular/router';


import { LandingpageComponent } from './landingpage/landingpage.component';
import { LoginComponent } from './login/login.component';
import { EmployeeOnboardingComponent } from './employee-onboarding/employee-onboarding.component';
import { TaskListComponent } from './task-list/task-list.component';
import { GettaskDetailsComponent } from './gettask-details/gettask-details.component';
import { LeftmenuComponent } from './leftmenu/leftmenu.component';

export const routes: Routes = [
 
  { path: '', component: LoginComponent, pathMatch: 'full' }, 
    
  
  { path: 'dashboard', component: LandingpageComponent ,
     children: [
      { path: 'empboard', component: EmployeeOnboardingComponent },
      { path: 'task/:taskId',component:GettaskDetailsComponent   },
   
      { path: 'taskList/completed',component:TaskListComponent   },  
      { path: 'menu',component:LeftmenuComponent ,
        children:[
          { path: 'taskList/:groupId',component:TaskListComponent   },  
       ]  
      },      
      { path: '', redirectTo: 'empboard', pathMatch: 'full' },
     ]
   },
];

