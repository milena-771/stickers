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
    <h1 class="my-2 fw-semibold">Edit all stickers</h1>

    <table class="table table-hover align-middle">
        <thead>
            <tr>
                <th>Image</th>
                <th>Created at</th>
                <th>Name</th>
                <th class="text-center">Delete/Update</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="sticker in stickers" :key="sticker.id" id="stickers">
            <td><img :src="sticker.imageUrl" class="img-thumbnail" style="width:3rem"></td>
            <td>{{ sticker.createdAt }}</td>
            <td>{{ sticker.name }}</td>
            <td class="text-center">
                <div class="my-2">
                    <RouterLink :to="{ name:'sticker-update', params:{id: sticker.id}}">
                        <button type="button" class="btn btn-outline-dark btn-sm" ><i class="bi bi-pencil-square"></i></button>
                    </RouterLink>
                </div>
                <div class="my-2">
                    <button type="button" class="btn btn-outline-dark btn-sm" @click="deleteSticker(sticker.id)"><i class="bi bi-trash3"></i></button>
                </div>
            </td>
            </tr>
        </tbody>

    </table>
</template>
<style>
table {
    border:none;
}
</style>
