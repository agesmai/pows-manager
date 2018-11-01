import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'pows-header',
  styleUrls: ['./header.component.scss'],
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit {

  title = 'pows-admin';

  ngOnInit() {
  }

}
