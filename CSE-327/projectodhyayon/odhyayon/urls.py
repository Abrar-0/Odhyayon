from django.urls import path
from . import views

urlpatterns=[

path('',views.homepage,name="index"),
path('loginproceed',views.loginproceed,name="loginProceed"),
path('studentlogin',views.studentlogin,name="studentLogin"),
path('teacherlogin',views.login_view,name="teacherLogin"),
path('signupproceed',views.signupproceed,name="signupProceed"),
path('teacherSignup',views.TeacherCreate.as_view(),name="teacherSignup"),
path('studentSignup',views.StudentCreate.as_view(),name="studentSignup"),
path('formsubmitted',views.formsubmitted,name="formsubmitted"),
path('dashboard',views.DashboardView.as_view(),name="dashboard"),
path('dashboard/<pk>', views.DetailView.as_view(), name="detail"),
path('dashboard/<pk>/assignment',views.uploadCreate.as_view(), name="create-upload" ),
path('dashboard/<pk>/delete',views.uploadDelete.as_view(), name="delete-upload" ),
path('dashboard/<pk>/addpdf', views.ClassUpdate.as_view(), name="update-class"),
path('dashboard/course/add/',views.ClassCreate.as_view(), name="create-class" ),
path('dashboard/course/<pk>/delete/',views.ClassDelete.as_view(), name="delete-class" ),



]