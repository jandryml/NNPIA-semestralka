import http from "./http-common";

const getAll = (params) => {
    return http.get("/film", {params});
};

const get = id => {
    return http.get(`/film/${id}`);
};

const save = data => {
    console.log("posting ", data);
    return http.post("/film", data);
};

const remove = id => {
    return http.delete(`/film/${id}`);
};

const findByTitle = title => {
    return http.get(`/tutorials?title=${title}`);
};

export default {
    getAll,
    get,
    save,
    remove,
    findByTitle
};
