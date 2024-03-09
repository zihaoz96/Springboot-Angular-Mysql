import { Injectable } from '@angular/core';
import axios, { AxiosRequestConfig, AxiosResponse } from 'axios';
import * as qs from 'qs';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  private apiUrl = 'http://localhost:8080/back';

  constructor() { }

  get<T>(endpoint: string, params?: any): Promise<any> {
    const queryParams = params ? `?${qs.stringify(params)}`:''
    
    const config: AxiosRequestConfig = {
      method: 'get',
      maxBodyLength: Infinity,
      url: `${this.apiUrl}/${endpoint}${queryParams}`,
    };

    return axios.request(config)
  }

  post<T>(endpoint: string, data: any): Promise<any> {
    const formData = qs.stringify(data);
    
    const config: AxiosRequestConfig = {
      method: 'post',
      maxBodyLength: Infinity,
      url: `${this.apiUrl}/${endpoint}`,
      data:formData,
      headers: { 
        'Content-Type': 'application/x-www-form-urlencoded'
      },
    };

    return axios.request(config)
  }

  // 封装PUT请求
  put<T>(endpoint: string, data: any): Promise<any> {
    const formData = qs.stringify(data); 
    
    const config: AxiosRequestConfig = {
      method: 'put',
      maxBodyLength: Infinity,
      url: `${this.apiUrl}/${endpoint}`,
      data:formData,
      headers: { 
        'Content-Type': 'application/x-www-form-urlencoded'
      },
    };

    return axios.request(config)
  }
}
