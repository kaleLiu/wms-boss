import aside_menu from "@/router/aside_menu";


const getRoute = (arr, tarr) => {
   arr.forEach(item => {
       tarr.push(item);
      if (item.children) {
          getRoute(item.children, tarr);
      } 
   });
}

const arr = [];

export default {

    list: [aside_menu[0]],
    selectedName: aside_menu[0].meta.title,

    set(route) {
        let f = this.list.find(x => x.meta.title === route.name);
        if (f) {
            this.selectedName = f.meta.title;
            return;
        }
        if (!arr.length) {
            getRoute(aside_menu, arr);
        }
        const nodes = arr.filter(item => item.meta.title === route.name);
        this.list = this.list.concat(nodes);
        //console.log(this.list);
        this.selectedName = route.name;
    },

    remove(routeName) {
        if (!this.list.length) return;
        let index = this.list.findIndex(x => x.meta.title === routeName);
        this.list.splice(index, 1);
        if (this.list.length - 1 < index) {
            index--;
        }
        this.selectedName = this.list[index].meta.title;
    } ,

    clearWindow(){
        this.list = [aside_menu[0]];
        this.selectedName = aside_menu[0].meta.title ;
    }

}