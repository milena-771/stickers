<script>
import { useRoute } from 'vue-router';
import { useVuelidate } from '@vuelidate/core'
import { required, maxLength, minValue, maxValue, url} from '@vuelidate/validators'

export default {
    /*props:{
        id: Number
    },*/
    setup(){
        return{
            route: useRoute(),
            v$:useVuelidate()
        }
    },

    data(){
        return{
            id:this.route.params.id,
            sizeList:[],
            aspectList:[],
            sticker:{
                name:"",
                imageUrl:"",
                sizeId:0,
                aspectId:0,
                price:"",
                description:""
            }
        }
    },
    validations(){
        return{
            sticker: {
                name:{required},
                imageUrl:{required, maxLength: maxLength(300), url},
                sizeId:{required},
                aspectId:{required},
                price:{required, minValue:minValue(0.01), maxValue: maxValue(100.00)},
                description:{ required, maxLength: maxLength(1000)}
            }
        }

    },
    methods:{

        async stickerDetails(){
            const options = {
                method: "GET"
            }
            const response = await fetch(`http://localhost:8080/stickers/${this.id}/for-update`, options);
            const finalResponse = await response.json();
            this.sticker = finalResponse;
        },
        async getSizes() {
            const options = {
                method: "GET"
            }
            const response = await fetch("http://localhost:8080/sizes", options);
            const finalResponse = await response.json();
            this.sizeList = finalResponse;
        },

        async getAspects() {
            const options = {
                method: "GET"
            }
            const response = await fetch("http://localhost:8080/aspects", options);
            const finalResponse = await response.json();
            this.aspectList = finalResponse;
        },

        async updateSticker(){
            const valid = await this.v$.$validate();
            if(valid){
                const options={
                    method:"PUT",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body:JSON.stringify(this.sticker)
                }
            const response = await fetch(`http://localhost:8080/stickers/${this.id}`, options);
            }
        }     
    },
    
    async created(){await this.stickerDetails(), await this.getSizes(), await this.getAspects()}

}
</script>
<template>
    
    <div class="container-fluid">
        <h1>Update Sticker</h1>
        <form class="g-3" @submit.prevent="updateSticker" novalidate>
            <div class="row">
                <div class="col-12 col-md-4 mb-3">
                    <label for="name" class="form-label required maxLength">Name</label>
                    <input v-model="sticker.name" :class="{'is-invalid': v$.sticker.name.$error}" name="name" type="text" id="name" class="form-control">
                </div>

                <div class="col-12 col-md-8 mb-3">
                    <label for="image" class="form-label required maxLength">Image Url</label>
                    <input v-model="sticker.imageUrl" :class="{'is-invalid': v$.sticker.imageUrl.$error}" name="imageUrl" type="url" id="imageUrl" class="form-control">
                </div>
            </div>

            <div class="row">
                <div class="col-12 col-md-4 mb-3">
                    <label for="size" class="form-label required">Size</label>
                    <select v-model="sticker.sizeId" :class="{'is-invalid': v$.sticker.sizeId.$error}" name="sizeId" id="size" class="form-select">
                        <option v-for="size in sizeList" :key="size.id" :value="size.id">{{ size.name }}</option>
                    </select>
                </div>
                <div class="col-12 col-md-4 mb-3">
                    <label for="aspect" class="form-label required">Aspect</label>
                    <select v-model="sticker.aspectId" :class="{'is-invalid': v$.sticker.aspectId.$error}" name="aspectId" id="aspect" class="form-select">
                        <option v-for="aspect in aspectList" :key="aspect.id" :value="aspect.id">{{ aspect.name }}</option>
                    </select>
                </div>
                <div class="col-12 col-md-4 mb-3">
                    <label for="price" class="form-label required minValue maxValue">Price</label>
                    <div class="input-group">
                        <span class="input-group-text">€</span>
                        <input  v-model="sticker.price" :class="{'is-invalid': v$.sticker.price.$error}" name="price" type="number" id="price" class="form-control" min="0.01" step="0.01">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="mb-3">
                    <label for="description" class="form-label required maxLength">Description</label>
                    <textarea v-model="sticker.description" :class="{'is-invalid': v$.sticker.description.$error}" name="description" id="description" class="form-control" rows="3"></textarea>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col d-flex justify-content-end content">
                    <button id="btn" type="submit"
                        class="btn col-12 col-md-2 btn-primary">Update</button>
                </div>
            </div>
        </form>
    </div>
 
</template>