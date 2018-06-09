<template>
  <v-app class="container" id="inspire">
    <v-layout>
      <v-flex text-xs-center>

        <v-layout row justify-center>
          <v-btn color="primary" dark @click.native.stop="dialog = true">Open Dialog</v-btn>
          <v-dialog v-model="dialog" max-width="600">
            <v-card>
              <v-card-title class="headline">https://github.com/ivosahlik/spring-boot-vuejs-skeleton</v-card-title>
              <v-card-text>java spring framework Fullstack developer</v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="green darken-1" flat="flat" @click.native="dialog = false">Disagree</v-btn>
                <v-btn color="green darken-1" flat="flat" @click.native="dialog = false">Agree</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-layout>

        <h1>{{ msg }}</h1>


        <h2>REST service call results</h2>

        <v-btn small color="primary" @click="callRestServiceAxios()">CALL Spring Boot REST backend service
          callRestServiceAxios
        </v-btn>

        <v-btn small color="primary" @click="getApiTest()">CALL Spring Boot REST backend service getTest</v-btn>

        <v-btn small color="primary" @click="callRestServiceHttp()">CALL Spring Boot REST backend service
          callRestServiceHttp
        </v-btn>


        <h4>Backend response: {{ response }}</h4>

        <h4>Backend response: {{ responseHtml }}</h4>

        <h4>Backend response:</h4>
        <div>
          <li v-for="row of responseFor">
            {{row.description}}
          </li>
        </div>

        <v-expansion-panel focusable>
          <v-expansion-panel-content v-for="(item,i) in 5" :key="i">
            <div slot="header">Item</div>
            <v-card>
              <v-card-text class="grey lighten-3">
                {{ responseHtml }} - {{i}}
              </v-card-text>
            </v-card>
          </v-expansion-panel-content>
        </v-expansion-panel>


        <div>
          <v-toolbar color="cyan" dark tabs>
            <v-tabs
              slot="extension"
              v-model="model"
              centered
              color="cyan"
              slider-color="yellow"
            >
              <v-tab
                v-for="i in 3"
                :key="i"
                :href="`#tab-${i}`"
              >
                Item {{ i }}
              </v-tab>
            </v-tabs>
          </v-toolbar>


          <v-tabs-items v-model="model">
            <v-tab-item
              v-for="i in 3"
              :key="i"
              :id="`tab-${i}`"
            >
              <v-card flat>
                <v-card-text v-text="text">{{ responseHtml }} - {{i}}</v-card-text>
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </div>



      </v-flex>
    </v-layout>
  </v-app>
</template>

<script>
  // import axios from 'axios'
  import {AXIOS} from '../http/http-common'

  export default {
    name: 'service',

    data () {
      return {
        msg: 'HowTo call REST-Services:',
        response: [],
        errors: [],
        responseHtml: '',
        responseFor: [],
        dialog: false,
        model: 'tab-2',
        text: ''

      }
    },
    created: function () {
      this.callRestServiceAxios()
    },
    methods: {
      callRestServiceAxios: function () {
        AXIOS.get(`/helloaxios`)
          .then(response => {
            this.response = response.data
            console.log(response.data)
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      callRestServiceHttp: function () {
        let url = 'http://localhost:8080/api/hellohttp'
        this.$http.get(url).then((res) => {
          this.responseHtml = res.bodyText
          this.text = this.responseHtml
          console.log(this.responseHtml)
        }, (err) => {
          console.log(err)
        })
      },
      getApiTest: function () {
        let url = 'http://localhost:8080/api/test'
        this.$http.get(url).then((res) => {
          this.responseFor = res.body
          console.log(this.response)
        }, (err) => {
          console.log(err)
        })
      }
    }
  }

</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
