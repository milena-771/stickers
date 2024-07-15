<script>
import { RouterLink } from 'vue-router';
</script>
<template>
    <header class="bg-light header">
        <nav class="container-xl navbar navbar-expand-lg ">
            <div class="container-fluid">
                    <RouterLink :to="{ name: 'home' }" class="navbar-brand">
                        <span>Stick-me</span>
                    </RouterLink>
                    <button class="navbar-toggler me-2" type="button" data-bs-toggle="collapse" data-bs-target="#navbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>   
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <RouterLink class="nav-link" :to="{ name: 'sticker-create' }">
                                    Create
                            </RouterLink>
                        </li>
                        <li class="nav-item">
                            <RouterLink class="nav-link" :to="{ name: 'stickers-edit' }">
                                    Edit
                            </RouterLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</template>
<style scoped>
.header{
    border-bottom: 2px greenyellow solid;
}
</style>