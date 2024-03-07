import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const authGuard: CanActivateFn = () => {
  const auth = inject(AuthService)
  const router = inject(Router)

  if(auth.getStatusAuth()){
    router.navigateByUrl('/login')
    return false
  }
  
  return true;
};
