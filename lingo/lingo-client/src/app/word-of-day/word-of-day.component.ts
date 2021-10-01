import { Component, OnInit } from '@angular/core';
import { Noun } from '../model/Noun';
import { NounService } from '../services/noun.service';

@Component({
  selector: 'app-word-of-day',
  templateUrl: './word-of-day.component.html',
  styleUrls: ['./word-of-day.component.css'],
})
export class WordOfDayComponent implements OnInit {
  fetchedWord = '';
  wordOfDay = '';
  listOfNouns: Noun[] = [];
  constructor(private nounService: NounService) {}

  ngOnInit(): void {
    this.getWordOfDay();
  }

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
  getWordOfDay(): void {
    this.nounService.getWordOfDay().subscribe((noun) => {
      this.wordOfDay = noun['value'];
    });
  }
}
