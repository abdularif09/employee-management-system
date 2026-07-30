import { HttpInterceptorFn } from '@angular/common/http';

export const jwtInterceptor: HttpInterceptorFn = (req, next) => {

   if (req.url.includes('/auth/login')) {
      return next(req);
   }

    const token = sessionStorage.getItem('jwtToken');
     if (token) {
        req = req.clone({
              setHeaders: {
                Authorization: `Bearer ${token}`
              }
      });
     }
  return next(req);
};
