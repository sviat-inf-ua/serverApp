import { Component } from '@angular/core';
import { Response } from '@angular/http';

import { ServerService } from './server.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  appName = this.serverService.getAppName();
  servers = [
    // {
    //   name: 'Testserver',
    //   capacity: 10,
    //   id: this.generateId()
    // },
    // {
    //   name: 'Liveserver',
    //   capacity: 100,
    //   id: this.generateId()
    // }
  ];
  server ;
  constructor(private serverService: ServerService) {}
  onAddServer(name: string, capacity: string) {
    this.servers.push({
      name: name,
      capacity: capacity,
      id: this.generateId()
    });
    this.server =  {
      name:name,
      capacity: capacity,
      id: this.generateId()
    }
  }
  onSave() {
    this.serverService.storeServers(this.server)
      .subscribe(
        (response) => console.log(response),
        (error) => console.log(error)
      );
  }
  onGet() {
    this.serverService.getServers()
      .subscribe(
        (servers: any[]) => this.servers = servers,
        (error) => console.log(error)
      );
  }
  private generateId() {
    return Math.round(Math.random() * 10000);
  }
}
