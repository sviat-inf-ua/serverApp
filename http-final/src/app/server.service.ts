import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ServerService {
  constructor(private http: Http) {}


  storeServers(servers: any[]) {
    const headers = new Headers({'Content-Type': 'application/json'});
    // return this.http.post('https://ng-http.server.com/data.json',
    //   servers,
    //   {headers: headers});
    return this.http.post('api/server',
      servers,
      {headers: headers});
  }

  getServers() {
    return this.http.get('api/servers')
      .map(
        (response: Response) => {
          console.log(response.json);
          const data = response.json();
          for (const server of data) {
            server.name = server.name;
          }
          return data;
        }
      )
      .catch(
        (error: Response) => {
          return Observable.throw('Something went wrong');
        }
      );
  }
  getAppName() {
    return this.http.get('api/servers')
      .map(
        (response: Response) => {
          console.log(response.json);
          return response.json();
        }
      );
  }
}
