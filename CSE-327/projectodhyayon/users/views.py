from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User
from users.models import UserProfileInfo
from django.shortcuts import render
from users.forms import UserForm, UserProfileInfoForm
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from django.contrib.auth.decorators import login_required
from django.views.generic import TemplateView
from .models import UserProfileInfo
from django.views.generic import CreateView
from django.contrib.auth import authenticate, login, logout


def index(request):
     return render(request, 'home.html')
 
def register(request):

         registered = False

         if request.method == "POST":
         
          user_form = UserForm(data=request.POST)
          profile_form = UserProfileInfoForm(data=request.POST)

          if user_form.is_valid() and profile_form.is_valid():
            
             user = user_form.save()
            # user.set_password(user.password)
             user.save()
             profile = profile_form.save(commit=False)
             profile.user = user
             profile.save()
             registered = True
          else:
            print(user_form.errors, profile_form.errors)
         else:
            
            user_form = UserForm()
            profile_form = UserProfileInfoForm()

         return render(request, 'users/registration.html',
-                            {'registered':registered,
-                             'user_form':user_form,
-                             'profile_form':profile_form})


def user_login(request):
     if request.method == "POST":
         username = request.POST.get('username')
         password = request.POST.get('password')
 
         user = authenticate(username=username, password=password)
 
         if user:
             if user.is_active:
                 login(request,user)
                 return HttpResponseRedirect(reverse('index'))
