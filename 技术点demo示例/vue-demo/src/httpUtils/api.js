import HttpRequest from './HttpRequest.js'
const baseUrl = process.env.API_ROOT;
let api = {
    //获取信息
    getMessage:function(datas){

        return HttpRequest.getRequest({
            method:'POST',
            url:baseUrl+'/getMessage',
            // url:'proxy/getMessage',
            data:datas
        });
    },


}
export default api;