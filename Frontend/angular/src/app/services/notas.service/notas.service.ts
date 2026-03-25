import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NotasModel } from '../../models/notas.model/notas.model';

@Injectable({
  providedIn: 'root',
})
export class NotasService {
  private url="http://localhost:8080/notas";

  constructor(private http:HttpClient){}

  getNotas(){
    return this.http.get<any>(this.url);
  }

}
