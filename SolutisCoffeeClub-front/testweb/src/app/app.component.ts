import { CapsulaCafe } from './../capsula';
import { CapsulaService } from './shared/capsula.service';
import { Component, OnInit } from '@angular/core';
import { Form, NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html', 
  styleUrls: ['./app.component.css', '../teste.css']
})
export class AppComponent implements OnInit{

  constructor(private capsulaService: CapsulaService){

  }

  capsulas: CapsulaCafe[]; 
  title = 'capsulas';
  capsula: CapsulaCafe;
  showCreation: boolean = false;
  creationForm: NgForm;

  
  ngOnInit(){
    this.getCapsulas();
    this.capsula = new CapsulaCafe();
  
  }
  createOrEdit(){
    this.showCreation = true;
  }
  notCreatingOrEditing(){
    this.showCreation = false;
    //this.creationForm.resetForm();
  }
    
  getCapsulas(){
    this.capsulaService.getAllCapsula().subscribe(data => {
      this.capsulas = data;
    });
  }

  deleteCapsula(capsula:CapsulaCafe){
    console.log(this.capsula.sabor);
    this.capsulaService.deleteCapsula(this.capsula.id).subscribe(data => {
      console.log("deleted");
    });
    this.getCapsulas();
   /* alert("Capsula deletada com sucesso");*/
  }

  saveCapsula(){
    console.log(this.capsula.sabor);
    console.log(this.capsula.marca);
    console.log(this.capsula.id);
    console.log(this.capsula.doses);

   this.capsulaService.saveCapsula(this.capsula).subscribe(result => {
     this.capsula;
   }) ; 
  }

  cancelar(){
    this.capsula = new CapsulaCafe();
  }
}
