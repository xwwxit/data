<template>
    <div>
        <h1>{{name}}</h1> 
        <button @click="clickMe">点我有惊喜</button>   
        <div>{{child}}</div>
        <button @click="sendData">发送数据给老二</button>
    </div>
</template>
<script>
import middleComponent from '@/event.js';
export default {
    props:{
            child:String
    },
    data(){
    return {
        name: '我是子组件一'
        }
    },
    methods:{
        clickMe(){
            this.$emit('showchild','我是从子组件一过来的');
        },
        sendData(){
            console.log(12313);
            middleComponent.$emit('send','来自组件一的数据')
        }
    }
}
</script>
<style>

</style>
