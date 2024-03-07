import { createReducer, on } from '@ngrx/store';
import * as AuthActions from './auth.actions';

export interface AuthState {
  isAuthenticated: boolean;
}

export const initialAuthState: AuthState = {
  isAuthenticated: false,
};

export const authReducer = createReducer(
  initialAuthState,
  on(AuthActions.loginSuccess, (state) => ({ ...state, isAuthenticated: true })),
  on(AuthActions.logout, (state) => ({ ...state, isAuthenticated: false }))
);