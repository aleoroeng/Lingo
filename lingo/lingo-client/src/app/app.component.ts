import { Component, OnInit } from '@angular/core';
import { NounService } from './services/noun.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'lingo-client';
  fetchedWord = '';
  constructor(private nounService: NounService) {}

  ngOnInit(): void {
    //
    this.getWord('hi');
  }

  getWord(value: string): void {
    this.nounService.getWord(value).subscribe((fetchedWord) => {
      this.fetchedWord = fetchedWord.getValue();
    });
  }
}
