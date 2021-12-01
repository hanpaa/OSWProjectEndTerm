<template>
  <div class="about">
<div id="app">
  <v-app id="inspire">
      
      <v-form
      >
        <v-container fluid>
            <v-text-field label="Title" ></v-text-field>

             <v-textarea
        
        label="Text"
      ></v-textarea>
        </v-container>
        <v-card-actions>
          <v-btn
            text
            @click="resetForm"
          >
            Cancel
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn
            text
            color="primary"
            type="submit"
          >
            Register
          </v-btn>
          <div v-for = 'politician in politicians' v-bind:key="politician.id">
          <p>{{politician.id}}</p>
           
          </div>
        </v-card-actions>
      </v-form>
      
      
  
       
  </v-app>
</div>  </div>
</template>

<script>
import axios from 'axios'

export default {
    data(){
        return{
            politicians: []
        }
    },
    mounted(){
        this.loadbbs();
        console.log(this.politicians)
    
    },
    methods: {
        loadbbs(){
            axios.get('http://teamfrankly.kr/api/politicians/1')
            .then(Response =>{
                this.politicians = Response.data;

            }).catch(error => console.log(error))
        }
    }
}
</script>
