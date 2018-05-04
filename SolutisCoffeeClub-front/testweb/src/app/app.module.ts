import { CrudService } from './shared-service/crud.service';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http'; 
import { NgModule, OnInit } from '@angular/core';
import *as $ from 'jquery';
import {Sine, Quad, TimelineMax, TweenMax} from "gsap";


import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule implements OnInit {

  ngOnInit(): void {
    this.menuBar()
  }

  menuBar() {
    $('ul a,#gotoTop').click(function(){
      var lienHref=$(this).attr('href');
      var positionHrefTop=$(lienHref).offset().top;
      $('html,body').animate({scrollTop:positionHrefTop-50},1000);
      return false;
  });
  }

 }
