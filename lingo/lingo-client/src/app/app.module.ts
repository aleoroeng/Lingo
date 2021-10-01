import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { TaskbarComponent } from './taskbar/taskbar.component';
import { WordOfDayComponent } from './word-of-day/word-of-day.component';

@NgModule({
  declarations: [AppComponent, HomepageComponent, TaskbarComponent, WordOfDayComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
