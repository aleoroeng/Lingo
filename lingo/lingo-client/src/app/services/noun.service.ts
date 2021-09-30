import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Noun } from '../model/Noun';

@Injectable({
  providedIn: 'root',
})
export class NounService {
  nounUrl = 'http;//localhost:8080/word/';
  constructor(private http: HttpClient) {}

  public getWord(value: string): Observable<Noun> {
    return this.http.get<Noun>(this.nounUrl + value);
  }
}
