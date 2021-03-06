import { Component, OnInit } from '@angular/core';
import { Noun } from './model/Noun';
import { NounService } from './services/noun.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'lingo-client';
  fetchedWord = '';
  listOfNouns: Noun[] = [];
  constructor(private nounService: NounService) {}

  ngOnInit(): void {}

  getWordById(id: number): void {
    this.nounService.getWordById(id).subscribe((fetchedWord) => {
      console.log(fetchedWord);
      this.fetchedWord = fetchedWord['value'];
    });
  }
  getWordByValue(noun: Noun): void {
    this.nounService.getWordByValue(noun).subscribe((listOfNouns) => {
      console.log(listOfNouns);
      this.listOfNouns = listOfNouns;
    });
  }
}
