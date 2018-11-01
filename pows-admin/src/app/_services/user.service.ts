import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../_models';
import {config} from 'rxjs';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(`${config}/users`);
  }

  getById(id: number) {
    return this.http.get(`${config}/users/` + id);
  }

  register(user: User) {
    return this.http.post(`${config}/users/register`, user);
  }

  update(user: User) {
    return this.http.put(`${config}/users/` + user.id, user);
  }

  delete(id: number) {
    return this.http.delete(`${config}/users/` + id);
  }
}
