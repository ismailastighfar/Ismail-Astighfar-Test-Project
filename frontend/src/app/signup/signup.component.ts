import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from "@angular/router";
import {AuthService} from "../auth-service.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm!: FormGroup;

  constructor(private fb: FormBuilder,private router: Router,private authService :AuthService) { }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.signupForm.valid) {
      // Store the user's credentials in local storage
      const credentials = this.signupForm.value;
      localStorage.setItem('credentials', JSON.stringify(credentials));

      this.router.navigateByUrl('/signin');

      console.log('Credentials stored:', credentials);
    }
  }
}
