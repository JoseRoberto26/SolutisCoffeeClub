import { CapsulaCafe } from './../capsula';
import { CapsulaService } from './shared/capsula.service';
import { Component, OnInit } from '@angular/core';
import { Form, NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html', 
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private capsulaService: CapsulaService){

  }

  capsulas: CapsulaCafe[] = []; 
  title = 'capsulas';
  capsula: CapsulaCafe;
  showCreation: boolean = false;

  
  ngOnInit(){
    this.getCapsulas();
    this.capsula = new CapsulaCafe();
  }

  showCreationForm( ){
    this.showCreation = !this.showCreation;
  }

  showEditForm(capsula: CapsulaCafe){
    if(this.showCreation == false){
      this.showCreation = true;
    }
  }
  
  getCapsulas(){
    this.capsulaService.getAllCapsula().subscribe(data => {
      this.capsulas = data;
    });
  }

  deleteCapsula(capsula:CapsulaCafe){
    this.capsulaService.deleteCapsula(capsula.id).subscribe(data => {
      this.capsulas.splice(this.capsulas.indexOf(capsula), 1);
      console.log("deleted");
    });
   /* alert("Capsula deletada com sucesso");*/
  }

  saveCapsula(){
    console.log(this.capsula.id);
    console.log(this.capsula.sabor);
    console.log(this.capsula.marca);
    console.log(this.capsula.doses);

   this.capsulaService.saveCapsula(this.capsula).subscribe(result => {
    this.capsulas.push(this.capsula);
  }) ; 
  this.capsula = new CapsulaCafe();
  }
}
