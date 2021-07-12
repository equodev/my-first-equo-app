<template>
 <div id="app">
   <img alt="Vue logo" src="./assets/logo.png" />
   <HelloWorld msg="Welcome to Your Vue.js App" />
 </div>
</template>
 
<script>
import HelloWorld from "./components/HelloWorld.vue";
import { Menu } from "@equo/equo-application-menu";
import { EquoCommService } from "@equo/comm";
 
let comm = EquoCommService.get();
 
export default {
 name: "App",
 components: {
   HelloWorld,
 },
 beforeMount() {
   Menu.create()
     .withMainMenu("File")
     .addMenuItem("Exit")
     .onClick(() => comm.send('exitevent'))
     .setApplicationMenu();
 },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
