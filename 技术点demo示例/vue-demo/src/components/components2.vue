<template>
    <div>
        <div>{{name}}</div>
        <div>{{data1}}</div>
    </div>
</template>
<script>
import middleComponent from '@/event.js';
export default {
    data(){
        return{
            name:'我是子组件2',
            data1:'',        
        }
    },methods:{

    },created(){
        middleComponent.$on('send',(data)=>{
                console.log(data);
                this.data1 = data;
            })
    }    
}
</script>
<style>

</style>
