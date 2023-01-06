from rest_framework import serializers
from myapiapp.models import Teacher

class TeacherSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model=Teacher
        fields=('ID','First_name', 'Last_name', 'Phone_number', 'Date_of_birth', 'Email','Password')
    