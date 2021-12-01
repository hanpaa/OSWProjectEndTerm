<template>

  <div class="detail" >
    <div id="app">
      
<v-container>
  <v-btn depressed >
        글쓰기
      </v-btn>
  <v-app id="inspire" outlined>
    <v-simple-table>
      <template v-slot:default>
        <thead>

          <tr>
            <th class="text-left">
              번호
            </th>
            <th class="text-left">
              내용
            </th>
            <th class="text-left">
              작성자
            </th>
            <th class="text-left">
              작성일자
            </th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in desserts"
            :key="item.name"
          >
            <td>{{ item.name }}</td>
            <td>{{ item.calories }}</td>
          </tr>
          
        </tbody>
        <v-pagination
        v-model="page"
        :length="6"
      ></v-pagination>
        <div class="text-center">
      
    </div>
      </template>

    
    </v-simple-table>
    
 
  </v-app>
  
  </v-container>
</div>
</div>
</template>