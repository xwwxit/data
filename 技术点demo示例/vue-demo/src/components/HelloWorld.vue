<template>
  <div>
  <div>{{msg}}</div>
  <div>{{name}}</div>
  <components1 @showchild="showchild"  :name="name"  :child="single"> </components1>
  <components2></components2>
  <button @click="clickget">你是什么垃圾</button>
  </div>
</template>

<script>
import components1 from '@/components/components1'
import components2 from '@/components/components2'
import api from '@/httpUtils/api.js';
export default {
  name: 'HelloWorld',
  data () {
    return {
      single:'给子组件买点吃的',
      name:'',
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods:{
    showchild(name){
      this.name = name;
    },
    clickget(){
      // console.log("干垃圾");
      let datas ={};//请求参数
      api.getMessage(datas).then(res=>{
        console.log(res);
         alert(res.laji);
      });
    }
  },mounted(){
      // this.get();
     //  console.log(api);
  },
  components:{
    components1,
    components2,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
