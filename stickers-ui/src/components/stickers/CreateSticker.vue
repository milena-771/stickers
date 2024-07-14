<script>
import { useVuelidate } from '@vuelidate/core'
import { required, maxLength, minValue, maxValue, url} from '@vuelidate/validators'

const validName = (value) => value === true; //check if a value is equal to true

export default {
    setup() {
        return { v$: useVuelidate()}
    },
    data() {
        return {
            uniqueName:true, //initialize boolean at true to detect if name is unique or not thanks to response of the server
            sizeList: [],
            aspectList: [],
            dataModel: {
                name: "",
                imageUrl: "",
                sizeId: "",
                aspectId: "",
                price: "",
                description: ""
            }
        }
    },
    validations() { 
        
        return {
            uniqueName:{ validName}, //uniqueName must be true to validate
            dataModel: {
                name: { required, maxLength: maxLength(100)},
                imageUrl: { required, maxLength: maxLength(300), url },
                sizeId: { required },
                aspectId: { required },
                price: { required, minValue:minValue(0.01), maxValue: maxValue(100.00) },
                description: { required, maxLength: maxLength(1000) }
            }
        }
    },
    methods: {
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

        resetForm(){
            Object.assign(this.$data.dataModel, this.$options.data().dataModel);
            this.v$.$reset();
        },

        displayToaster(){
            const myToast = document.querySelector('.toast');
            const toast = bootstrap.Toast.getOrCreateInstance(myToast);
            toast.show();
        },

        async post(){
            const response = await this.postSticker();
            if(await response){
                const myStatus =  await response.status; //retrieve the status code from the server response if there is an error
                if( await myStatus == 500){
                    this.uniqueName = false;// if status code 500 it means that the name is not unique in the database, uniqueName becomes false
                }                
            }
        },

        async postSticker() {
            const valid = await this.v$.$validate();
            if (valid) {
                const options = {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(this.dataModel)
                }
                const response = await fetch("http://localhost:8080/stickers", options)
                if(!response.ok){ //check if server send back a response, if there is an error server side
                    return await response.json();
                }
                this.resetForm();
                this.displayToaster();
                
            }
        }

    },
    async mounted() { await this.getSizes(), await this.getAspects() }


}
</script>

<template>
    <div class="container-fluid">
        <h1 class="mb-2 fw-semibold">Create a sticker</h1>
        <form class="g-3" @submit.prevent="post" novalidate>
            <div class="row">
                <div class="col-12 col-md-4 mb-3">
                    <label for="name" class="form-label required maxLength">Name</label>
                    <input v-model="dataModel.name" :class="{ 'is-invalid': v$.dataModel.name.$error || v$.uniqueName.$error}" name="name"
                        type="text" id="name" class="form-control">
                        <!--After validation, check server side if the name is unique, if not this message appears under the input-->
                    <div class=" form-text text-danger" v-if="v$.uniqueName.$error">This name is already used for a sticker.</div> 
                    
                </div>

                <div class="col-12 col-md-8 mb-3">
                    <label for="image" class="form-label required maxLength">Image Url</label>
                    <input v-model="dataModel.imageUrl" :class="{ 'is-invalid': v$.dataModel.imageUrl.$error }"
                        name="imageUrl" type="url" id="imageUrl" class="form-control">
                </div>
            </div>

            <div class="row">
                <div class="col-12 col-md-4 mb-3">
                    <label for="size" class="form-label required">Size</label>
                    <select v-model="dataModel.sizeId" :class="{ 'is-invalid': v$.dataModel.sizeId.$error }" name="sizeId"
                        id="size" class="form-select">
                        <option v-for="size in sizeList" :key="size.id" :value="size.id">{{ size.name }}</option>
                    </select>
                </div>
                <div class="col-12 col-md-4 mb-3">
                    <label for="aspect" class="form-label required">Aspect</label>
                    <select v-model="dataModel.aspectId" :class="{ 'is-invalid': v$.dataModel.aspectId.$error }"
                        name="aspectId" id="aspect" class="form-select">
                        <option v-for="aspect in aspectList" :key="aspect.id" :value="aspect.id">{{ aspect.name }}
                        </option>

                    </select>
                </div>
                <div class="col-12 col-md-4 mb-3">
                    <label for="price" class="form-label required minValue maxValue">Price</label>
                    <div class="input-group">
                        <span class="input-group-text">€</span>
                        <input v-model="dataModel.price" :class="{ 'is-invalid': v$.dataModel.price.$error }" name="price"
                            type="number" id="price" class="form-control" min="0.01" step="0.01">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="mb-3">
                    <label for="description" class="form-label required maxLength">Description</label>
                    <textarea v-model="dataModel.description" :class="{ 'is-invalid': v$.dataModel.description.$error }"
                        name="description" id="description" class="form-control" rows="3"></textarea>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col d-flex justify-content-end content">
                    <button id="btn" type="submit"
                        class="btn col-12 col-md-2 btn-primary">Create</button>

                    <!-- Toast - Success create event -->
                    <div class="toast-container position-fixed bottom-0 end-0 p-3">
                        <div class="toast bg-success text-white" role="alert">
                            <div class="toast-body">
                                Sticker created with success.
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </form>
    </div>

</template>

<style>
.required::after {
    content: " *";
    color: #FF0000;
}
</style>