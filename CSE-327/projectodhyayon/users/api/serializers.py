from rest_framework import serializers
from rest_framework.exceptions import ValidationError
from users.models import UserProfileInfo
from users.models import User
from rest_framework.validators import UniqueValidator 
from users import models


    
class StudentSerializer(serializers.ModelSerializer):
  
    #user = UserSerializer(many=False)

    class Meta:
        model = UserProfileInfo
        #fields = ('user', 'user_type',)
        fields = ('user_type')
    
    
        #student, created = UserProfileInfo.objects.update_or_create(user=user,
                            #user_type=validated_data.pop('user_type'))


class UserSerializer(serializers.ModelSerializer):
  
    class Meta:
        model = User
        #fields = ('username', 'first_name', 'last_name', 'password1','password2','email','user_type') 
        fields = '__all__'
    
    def create(self, validated_data):

        # create user 
        user = User.objects.create(
            username = validated_data.get('username'),
            last_name = validated_data.get('last_name'),
            first_name = validated_data.get('first_name'),
            password = validated_data.get('password'),
            
            #user_type = validated_data['user_type']
            # etc ...
        )

        
        user.save()

        profile_data = validated_data.get('user_type')

        
        
        UserProfileInfo.objects.create(
            user = user,
            user_type = profile_data,
            
            # etc...
        )

        return user