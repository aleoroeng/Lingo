import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Noun } from '../model/Noun';

@Injectable({
  providedIn: 'root',
})
export class NounService {
  nounUrl = 'http://localhost:8080/word';
  constructor(private http: HttpClient) {}

  public getWordById(id: number): Observable<Noun> {
    return this.http.get<Noun>(this.nounUrl, {
      params: {
        id: id,
      },
    });
  }
  public getWordByValue(noun: Noun): Observable<Noun[]> {
    return this.http.post<Noun[]>(this.nounUrl + `/value`, noun);
  }

  public getWordOfDay(): Observable<Noun> {
    return this.http.get<Noun>(this.nounUrl + '/daily');
  }
}
