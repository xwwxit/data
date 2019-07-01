import axios from "axios";
import { Toast } from "mint-ui";
var HttpRequest = {
  getRequest({ url, data = {}, method = "GET" }) {
    return new Promise((resolve, reject) => {
      this._getRequest(url, resolve, reject, data, method);
    });
  },
  _getRequest: function(url, resolve, reject, data = {}, method = "GET") {
    let format = method.toLocaleLowerCase() ==='get'?'params':'data';
    axios({
      url: url,
      method: method,
      [format]: data,
      header: {
        "content-type": "application/json"
      }
    }).then(res => {
    //   if (res.code == 0) {
    //     resolve(res);
    //   } else if (res.code == -1) {
    //     resolve(res);
    //   }
    resolve(res.data);
    }).catch(() => {
      reject();
      Toast({
        message: "发生错误，请检查！",
        position: "middle",
        duration: 2000
      });
    })
  }
};
export default HttpRequest;