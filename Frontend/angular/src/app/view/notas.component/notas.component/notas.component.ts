import { Component } from '@angular/core';
import { NotasModel } from '../../../models/notas.model/notas.model';
import { NotasService } from '../../../services/notas.service/notas.service';
import { ChangeDetectorRef } from '@angular/core';



@Component({
  selector: 'app-notas.component',
  imports: [],
  templateUrl: './notas.component.html',
  styleUrl: './notas.component.css',
})

export class NotasComponent {
  modal=document.getElementById("nota");
  span = document.getElementsByClassName("close")[0];

  notas: NotasModel | undefined;

  constructor(private notasService:NotasService, private changeD:ChangeDetectorRef){

    this.notasService.getNotas().subscribe(data=>{
      this.notas=data;
      console.log(this.notas);
      this.changeD.detectChanges();
    });
  }

  nuevaNota(){
    if(this.modal){
      this.modal.style.display="block";
    }
  }
  
/* 
  if(span){
    this.span.onclick = function() {
      modal.style.display = "none";
    }
  } */

  

}
