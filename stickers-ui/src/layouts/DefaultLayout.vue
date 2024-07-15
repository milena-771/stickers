<script setup>
import { RouterView } from 'vue-router';
import Header from '../components/commons/Header.vue';
</script>
<template>
    <Header/>
    <main class="container-xl">
        <RouterView />
    </main>
</template>