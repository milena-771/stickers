<script>
import { RouterLink } from 'vue-router';

export default{

    data(){
        return{
            stickers:[]
        }
    },
    methods:{

        async getStickers(){
            const options ={
                method: "GET"
            }
            const response = await fetch("http://localhost:8080/stickers", options);
            const finalResponse = await response.json();
            this.stickers = finalResponse;
        },
        async deleteSticker(id){
            const options = {
                method: "DELETE"
            }
            const response = await fetch(`http://localhost:8080/stickers/${id}`, options);
            window.location.reload();
        }
    },
    async created(){await this.getStickers()}
}
</script>
<template>
    <h1>Edit all stickers</h1>
    <table>
        <tr v-for="sticker in stickers" :key="sticker.id" id="stickers">
            <td><img :src="sticker.imageUrl" class="img-thumbnail" style="width:3rem"></td>
            <td class="text-center">{{ sticker.createdAt }}</td>
            <td class="text-center">{{ sticker.name }}</td>
            <td><button type="button" class="btn btn-outline-dark btn-sm" @click="deleteSticker(sticker.id)"><i class="bi bi-trash3"></i></button></td>
            <td><router-link :to="{name:'sticker-update', params:{
                                    id: sticker.id
                                    }}" >
                    <button type="button" class="btn btn-outline-dark btn-sm" ><i class="bi bi-pencil-square"></i></button>
                </router-link>
            </td>
        </tr>
    </table>
</template>
<style>
table {
    border:none;
}
</style>
