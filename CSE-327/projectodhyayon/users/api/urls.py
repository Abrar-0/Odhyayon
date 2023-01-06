from users.api.views import StudentRecordView
from django.urls import path
from users.api import views





app_name = "users"

urlpatterns = [
    path('register',views.StudentRecordView.as_view(),name="register")
]
