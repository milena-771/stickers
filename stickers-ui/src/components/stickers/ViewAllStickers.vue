<script>
import { RouterLink } from 'vue-router';

export default {
    
    data(){
        return{
            stickers:[]
        }
    },
    methods:{

        async getStickers(){
            const options = {
                method: "GET"
            }
            const response = await fetch("http://localhost:8080/stickers", options);
            const finalResponse = await response.json();
            this.stickers = finalResponse;
        },

    },
    async created(){await this.getStickers()}
}
</script>
<template>
        <h1 class="my-2 fw-semibold">View All Stickers</h1>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-2 mx-2" >
            <div class="col" v-for="sticker in stickers" :key="sticker.id" id="stickers">
                <div class="card p-0" >    
                    <div class="card-body p-2">
                        <img :src="sticker.imageUrl" class="card-img-top" >
                        <h5 class="card-title text-center">{{sticker.name}}</h5>
                        <p class="card-text text-center">{{ sticker.price }} €</p>
                    </div>
                    <div class="card-footer">
                        <router-link :to="{name:'sticker-detail', params:{
                                    id: sticker.id
                                    }}" >
                            <button type="button" class="btn btn-outline-secondary btn-sm"><i class="bi bi-eye"></i></button>
                        </router-link>
                    </div>
                </div>
            </div>
        </div>
</template>
<style scoped>/*scoped attribute  CSS will to elements of current component only*/
.card-footer{ 
    text-align: end;
}
.card-footer i{
    font-size:1.5rem;
}
.card:hover {
    border-color: grey;
    border-width: 0.1rem;
}

</style>
