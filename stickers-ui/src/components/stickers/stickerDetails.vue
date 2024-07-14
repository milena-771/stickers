<script>
//import ViewAllStickers from "./ViewAllStickers.vue";
import { useRoute } from 'vue-router';

export default {
    /*props:{
        id: Number //type of
    },*/
    setup(){
        return{
            route:useRoute()
        }
    },
    data(){
        return{
            id: this.route.params.id, //this.$route.params.id is obsolete in Vue 3
            sticker:{}
        }
    },
    methods:{

        async stickerDetails(){
            const options = {
                method: "GET"
            }
            const response = await fetch(`http://localhost:8080/stickers/${this.id}`, options);
            //if we had put this.$route.params.id it would have been of type String, here we use the props which cast id from String to Number from our router
            const finalResponse = await response.json();
            this.sticker = finalResponse;
        }
        

    },
    async mounted(){await this.stickerDetails()}
}
</script>
<template>
    <h1>View Sticker detail</h1>
    <div class="card m-5" > 
        <div class="row g-2">
            <div class="col-md-4 text-center">
                <img :src="sticker.imageUrl" class="img-fluid rounded-start p-2" >
            </div>  
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">{{sticker.name}}</h5>
                    <p class="card-text">Size : {{ sticker.sizeName }}</p>
                    <p class="card-text">Aspect : {{ sticker.aspectName}}</p>
                    <p class="card-text">Description : {{ sticker.description }} </p>
                    <p class="card-text">Price : {{ sticker.price }} €</p>
                </div>
            </div>
        </div>
    </div>
</template>


