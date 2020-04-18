import React, { useState, useEffect } from "react";
import { LinkContainer } from "react-router-bootstrap";

import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

import { ajax } from "rxjs/ajax";
import { map } from "rxjs/operators";
import { BASE_URL, API_ENDPOINTS } from "../../endpoints";

function ListarProdutos() {
  const [produtos, setProdutos] = useState([]);

  useEffect(() => {
    ajax(BASE_URL + API_ENDPOINTS.product)
      .pipe(map((ajaxResponse) => ajaxResponse.response))
      .subscribe((produtosDoBackend) => setProdutos(produtosDoBackend));
  }, []);

  const renderProduto = (produto) => {
    return (
      <Card className="produto">
        <Card.Img variant="top" src={produto.image} />
        <Card.Body>
          <Card.Title>{produto.name}</Card.Title>
          <LinkContainer to={"/produtos/" + produto.id}>
            <Button variant="primary" block>
              Visualizar
            </Button>
          </LinkContainer>
        </Card.Body>
      </Card>
    );
  };

  return <div className="listaDeProdutos">{produtos.map(renderProduto)}</div>;
}

export default ListarProdutos;
