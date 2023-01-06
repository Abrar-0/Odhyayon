from myapiapp.views import PersonViewset
from myapiapp.views import teacherApi
from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from myapiapp import views

from django.conf.urls.static import static
from django.conf import settings
from django.contrib import admin
from django.urls import path
from django.conf.urls import include
from rest_framework import routers

router = routers.DefaultRouter()
router.register(r'heroes', PersonViewset, basename='heroes')

urlpatterns=[
    path('', include(router.urls)),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework')),
    url(r'^teacher/$',views.teacherApi),
    url(r'^teacher/([0-9]+)$',views.teacherApi),
    
]+static(settings.MEDIA_URL,document_root=settings.MEDIA_ROOT)
